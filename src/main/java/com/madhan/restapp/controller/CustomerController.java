//package com.madhan.restapp.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.madhan.restapp.model.Customer;
//import com.madhan.restapp.service.CustomerService;
//
//@RestController
//@CrossOrigin("*")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService service;
//
//    @PostMapping("/registerCustomer")
//    public ResponseEntity<String> register(@RequestBody Customer customer) {
//        try {
//            if (customer.getEmail() == null || customer.getPassword() == null || customer.getPhoneNo() == null || customer.getCustomerName() == null) {
//                return ResponseEntity.badRequest().body("All fields are required.");
//            }
//
//            if (!customer.getPassword().equals(customer.getReEnterPassword())) {
//                return ResponseEntity.badRequest().body("Passwords do not match.");
//            }
//
//            service.addCustomer(customer);
//
//            return ResponseEntity.ok("Customer registered successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error occurred during registration: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/loginCustomer")
//    public ResponseEntity<?> login(@RequestBody Customer customer) {
//        try {
//            Optional<Customer> customerOptional = service.findByEmail(customer.getEmail());
//            if (!customerOptional.isPresent()) {
//                return ResponseEntity.badRequest().body("Invalid email");
//            }
//
//            Customer customerFound = customerOptional.get();
//            if (!customer.getPassword().equals(customerFound.getPassword())) {
//                return ResponseEntity.badRequest().body("Invalid password");
//            }
//
//            // Store customer ID in session
////            session.setAttribute("customerId", customerFound.getCustomerId());
//            
//            loggedInUsers.put(customerFound.getEmail(), customerFound.getPassword());
//
//            Map<String, Long> map = new HashMap<>();
//            map.put("customerId", customerFound.getCustomerId());
//
//            return ResponseEntity.ok(map);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error occurred during login: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/logout")
//    public ResponseEntity<String> logout(HttpSession session) {
//        session.invalidate();
//        return ResponseEntity.ok("Logged out successfully");
//    }
//
//    @GetMapping("/findAllCustomers")
//    public ResponseEntity<List<Customer>> findAllCustomers() {
//        List<Customer> customers = service.findAllCustomers();
//        return ResponseEntity.ok(customers);
//    }
//}

package com.madhan.restapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.madhan.restapp.model.Customer;
import com.madhan.restapp.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService service;

    private static Map<String, String> loggedInUsers = new HashMap<>();

    @PostMapping("/registerCustomer")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        try {
            if (customer.getEmail() == null || customer.getPassword() == null || customer.getPhoneNo() == null || customer.getCustomerName() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }

            if (!customer.getPassword().equals(customer.getReEnterPassword())) {
                return ResponseEntity.badRequest().body("Passwords do not match.");
            }

            service.addCustomer(customer);
            return ResponseEntity.ok("Customer registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred during registration: " + e.getMessage());
        }
    }

    @PostMapping("/loginCustomer")
    public ResponseEntity<?> login(@RequestBody Customer customer) {
        try {
            Optional<Customer> customerOptional = service.findByEmail(customer.getEmail());
            if (!customerOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid email");
            }

            Customer customerFound = customerOptional.get();
            if (!customer.getPassword().equals(customerFound.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }

            // Store logged-in users
            loggedInUsers.put(customerFound.getEmail(), customerFound.getPassword());

            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred during login: " + e.getMessage());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String email) {
        if (loggedInUsers.remove(email) != null) {
            return ResponseEntity.ok("Logged out successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user logged in with the given email");
        }
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<?> findAllCustomers(@RequestHeader("Authorization") String email) {
        if (!loggedInUsers.containsKey(email)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        try {
            List<Customer> customers = service.findAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while fetching customers: " + e.getMessage());
        }
    }
}

