package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.MuzixRepository;
import com.stackroute.muzixapp.service.MuzixService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping(value="api/v1")
    public class MuzixController {
        MuzixService muzixService;

        @Autowired
        public MuzixController(MuzixService muzixService) {
            this.muzixService = muzixService;
        }

        @PostMapping("muzix")
        public ResponseEntity<?> saveUser(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
            ResponseEntity responseEntity;

                muzixService.saveUser(muzix);
                responseEntity = new ResponseEntity<String>("creation successful", HttpStatus.CREATED);
            return responseEntity;


        }

        @GetMapping("muzix")
        public ResponseEntity<?> getAllUsers() {
            return new ResponseEntity<List<Muzix>>(muzixService.getAllUsers(), HttpStatus.OK);

        }

        @DeleteMapping("muzix/{trackId}")
        public ResponseEntity<?> deleteUser(@PathVariable int trackId) throws TrackNotFoundException {
            ResponseEntity responseEntity;
                muzixService.deleteById(trackId);
                responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllUsers(), HttpStatus.OK);


            return responseEntity;
        }

        @PutMapping("muzix/{trackId}")
        public ResponseEntity<?> updateUser(@RequestBody Muzix muzix, @PathVariable int trackId) throws TrackNotFoundException {
            ResponseEntity responseEntity;
                muzixService.updateMuzix(muzix, trackId);
                responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getAllUsers(), HttpStatus.OK);

            return responseEntity;
        }

//        @GetMapping(value = "muzix/{name}")
//        public ResponseEntity<List<Muzix>> getTrackByName(@PathVariable String name) throws TrackNotFoundException {
//            ResponseEntity responseEntity;
//
//                responseEntity = new ResponseEntity<List<Muzix>>(muzixService.getMuzixByName1(name), HttpStatus.OK);
//
//            return responseEntity;
//        }
    }







