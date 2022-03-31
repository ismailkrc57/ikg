package com.scpg.ikg.api.controller;

import com.scpg.ikg.business.abstracts.ISolutionService;
import com.scpg.ikg.core.api.ControllerBase;
import com.scpg.ikg.core.utilities.results.ErrorResult;
import com.scpg.ikg.entities.concretes.Solution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/solutions")
public class SolutionController extends ControllerBase<Solution, ISolutionService> {

    ISolutionService iSolutionService;

    public SolutionController(ISolutionService iSolutionService) {
        super(iSolutionService);
        this.iSolutionService = iSolutionService;
    }

    @GetMapping("/getallsolutiondetail")
    ResponseEntity<?> getAllSolutionDetail() {
        var result = iSolutionService.getAllSolutionDetail();
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getallsolutionbyhomework")
    ResponseEntity<?> getAllSolutionDetailByHomework(@RequestParam int homeworkId) {
        var result = iSolutionService.getSolutionDetailDtoByHomework(homeworkId);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getsolutionupdatedtobyid")
    ResponseEntity<?> getSolutionUpdateDtoById(@RequestParam int solutionId) {
        var result = iSolutionService.getSolutionUpdateDtoById(solutionId);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new ErrorResult(result.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
