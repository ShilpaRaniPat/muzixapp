package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Muzix;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {
    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl( MuzixRepository userRepository){
        this.muzixRepository=userRepository;
    }
    @Override
    public Muzix saveUser(Muzix muzix) {
        Muzix savedUser=muzixRepository.save(muzix);
        return savedUser;
    }

    @Override
    public List<Muzix> getAllUsers() {
        return muzixRepository.findAll();
    }

    @Override
    public List<Muzix> deleteById(int trackId)
    {
        muzixRepository.deleteById(trackId);
        return muzixRepository.findAll();

    }
    @Override
    public void findById(int trackId){
        muzixRepository.findById(trackId);
        return;

    }
    @Override
    public List<Muzix> updateUsers(Muzix muzix,int trackId){
        muzixRepository.findById(trackId);
        Muzix updatedUser=muzixRepository.save(muzix);
        return muzixRepository.findAll();

    }




}
