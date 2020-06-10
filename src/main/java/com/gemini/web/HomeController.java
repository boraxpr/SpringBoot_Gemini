package com.gemini.web;

import com.gemini.model.Employee;
import com.gemini.ocs.model.BaseSciencePlan;
import com.gemini.repository.EmployeeRepository;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @CrossOrigin
    @GetMapping("/")
    public @ResponseBody String root() {
        return "Welcome welcome";
    }


    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password){
//        test user
        Employee user = new Employee('0', "poolsawat","Naipawat","Poolsawat","naipawat");
        employeeRepository.save(user);
        if(employeeRepository.findByEmail(username) != null)
        {
            Employee employee = employeeRepository.findByEmail(username);
                if (employee.getEmail()==username && employee.getPassword()==password)
                {
                    return new ResponseEntity<>(Jwts.builder().setSubject(employee.getEmail()).claim("roles", "user").setIssuedAt(new Date())
                            .signWith(SignatureAlgorithm.HS256, "secretkey").compact(), HttpStatus.OK);
                }
        }
        return new ResponseEntity<>("No user or wrong password",HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/addsciplan")
    public ResponseEntity<String> addSciplan(@RequestParam int planNo,
                                             @RequestParam String creator,
                                             @RequestParam String submiter,
                                             @RequestParam double fundingInUSD,
                                             @RequestParam String objectives,
                                             @RequestParam String starSystem,
                                             @RequestParam Date startDate,
                                             @RequestParam Date endDate,
                                             @RequestParam String TELESCOPELOC,
//                                        to create ocs.model.dataProcRequirements
                                             @RequestParam String fileType,
                                             @RequestParam double fileQuality,
                                             @RequestParam String COLORTYPE,
                                             @RequestParam double contrast,
                                             @RequestParam double brightness,
                                             @RequestParam double saturation,
//                                        to create ocs.model.BaseObservingProgram
                                             @RequestParam int observingProgramId,
//                                          to create ocs.model.LocationElement
                                             @RequestParam String body,
                                             @RequestParam boolean apparentOfDate,
//                                          to create ocs.model.Lens
                                             @RequestParam String LensMake,
                                             @RequestParam String LensModel,
                                             @RequestParam String LensManufacturer,
                                             @RequestParam int LensYear,
//                                        to create BaseObservingProgram not finished
//                                             @RequestParam
//                                        to create BaseSciencePlan attribute
                                        @RequestParam BaseSciencePlan.STATUS status){
        return new ResponseEntity<>("SciPlan Added",HttpStatus.OK);
    }
}