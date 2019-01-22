package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Muzix;

import java.util.List;

public interface MuzixService {

    public Muzix saveUser(Muzix muzix);



        public List<Muzix> getAllUsers();
        public List<Muzix> deleteById(int trackId);
        public List<Muzix> updateUsers(Muzix muzix,int trackId);
         public void findById(int trackId);
    }




