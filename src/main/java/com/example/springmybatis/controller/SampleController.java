package com.example.springmybatis.controller;

import com.example.springmybatis.model.GenericResponse;
import com.example.springmybatis.model.Student;
import com.example.springmybatis.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {
    @Autowired
    private StuRepository stuRepo;

    @RequestMapping(value="/public/addStu", method= RequestMethod.POST)
    public ResponseEntity<GenericResponse> addStu(
            @RequestBody
                    Student stuToAdd
    )
    {
        GenericResponse retMsg = new GenericResponse();
        if(stuToAdd != null)
        {
            int affectrow = 0;
            try
            {
                affectrow = stuRepo.addStu(stuToAdd);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

            if(affectrow>0){
                retMsg.setSuccess(true);
                retMsg.setStatusMsg("Operation is successful.");
            }else{
                retMsg.setSuccess(false);
                retMsg.setStatusMsg("Exception occurred.");
            }

        }
        else
        {
            retMsg.setSuccess(false);
            retMsg.setStatusMsg("No valid stu model object to be added");
        }

        ResponseEntity<GenericResponse> retVal;
        retVal = ResponseEntity.ok(retMsg);
        return retVal;
    }

    @RequestMapping(value="/public/findStus", method=RequestMethod.GET)
    public ResponseEntity<Student> findStusById(
            @RequestParam("id")
                    Integer id)
    {
        Student foundStus = stuRepo.findStuById(id);

        if(foundStus == null){
            foundStus = new Student();
        }

        ResponseEntity<Student> retVal;
        retVal = ResponseEntity.ok(foundStus);
        return retVal;
    }

    @RequestMapping(value="/public/delStus", method=RequestMethod.POST)
    public ResponseEntity<GenericResponse> delStusById(
            @RequestParam("id")
                    Integer id)
    {
        GenericResponse retMsg = new GenericResponse();
        int affectrow = 0;
        try
        {
            affectrow = stuRepo.deleteStuById(id);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        if(affectrow>0){
            retMsg.setSuccess(true);
            retMsg.setStatusMsg("Operation is successful.");
        }else{
            retMsg.setSuccess(false);
            retMsg.setStatusMsg("Exception occurred.");
        }
        ResponseEntity<GenericResponse> retVal;
        retVal = ResponseEntity.ok(retMsg);
        return retVal;
    }

    @RequestMapping(value="/public/updateStu", method= RequestMethod.POST)
    public ResponseEntity<GenericResponse> updateStu(
            @RequestBody
                    Student stuToUpd
    )
    {
        GenericResponse retMsg = new GenericResponse();
        if(stuToUpd != null)
        {
            int affectrow = 0;
            try
            {
                affectrow = stuRepo.updateStuById(stuToUpd);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

            if(affectrow>0){
                retMsg.setSuccess(true);
                retMsg.setStatusMsg("Operation is successful.");
            }else{
                retMsg.setSuccess(false);
                retMsg.setStatusMsg("Exception occurred.");
            }

        }
        else
        {
            retMsg.setSuccess(false);
            retMsg.setStatusMsg("No valid stu model object to be added");
        }

        ResponseEntity<GenericResponse> retVal;
        retVal = ResponseEntity.ok(retMsg);
        return retVal;
    }
}