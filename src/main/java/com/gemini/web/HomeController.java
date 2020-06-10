package com.gemini.web;

import com.gemini.model.Employee;
import com.gemini.model.SciencePlan;
import com.gemini.repository.EmployeeRepository;
import com.gemini.repository.SciplanRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import org.json.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SciplanRepository sciplanRepository;
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
        Employee user = new Employee('0', "naipawat","password","Naipawat","Poolsawat");
        employeeRepository.save(user);
        if(employeeRepository.findByUsername(username) != null)
        {
            Employee employee = employeeRepository.findByUsername(username);
                if (employee.getUsername().equals(username) && employee.getPassword().equals(password))
                {
                    JSONObject jsonString =  new JSONObject();
                    jsonString.put("token",Jwts.builder().setSubject(employee.getUsername()).claim("roles", "user").setIssuedAt(new Date())
                            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());

                    return new ResponseEntity<>(jsonString.toString(), HttpStatus.OK);
                }
        }
        return new ResponseEntity<>("User not found",HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/addsciplan")
    public ResponseEntity<String> addSciplan(@RequestParam int planNo,
                                             @RequestParam String creator,
                                             @RequestParam String submiter,
                                             @RequestParam double fundingInUSD,
                                             @RequestParam String objectives,
                                             @RequestParam String starSystem,
                                             @RequestParam String startDate,
                                             @RequestParam String endDate,
                                             @RequestParam String TELESCOPELOC,
                                             //TELESCOPELOC = {String TELESCOPELOC :HAWAII or CHILE}
                                             @RequestParam ArrayList<String> dataProcRequirements,
                                             //dataProcRequirement =
                                             //{string 'fileType':'RAW'or'PNG'or'JPEG'or'TIFF'
                                             //,double 'fileQuality'
                                             //,string 'COLOR_TYPE':'BW'or'COLOR'
                                             //,double 'contrast'
                                             //,double 'brightness'
                                             //,double 'saturation'}
                                             @RequestParam ArrayList<String> observingProgram,
                                             //observingProgram =
                                             //{int 'id'
                                             //LocationElement : {double longitude,double latitude,double radius}
                                             //Lens : {String make,String model, String manufacturer, int year}
                                             //ArrayList<Filter> for each Filter {String make,String model,String manufacturer,int year,double size,double weight}}
                                             //ArrayList<Double>
                                             //boolean isLightDetectorOn
                                             //ArrayList<SpecialEquipment> for each SpecialEquipment {String equipmentName,String ownerName,Date installedDate}
                                             //AstronomicalData : List of images
                                             @RequestParam String status
                                             //status = {String 'status': COMPLETE or RUNNING or SUMMITTED}
                                        ) throws ParseException {
        Date StartDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Date EndDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
        sciplanRepository.save(new SciencePlan(planNo,creator,submiter,fundingInUSD,objectives,starSystem,StartDate,EndDate,TELESCOPELOC,dataProcRequirements,observingProgram,status));
        return new ResponseEntity<>("SciPlan Added",HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getsciplan")
    public @ResponseBody
    Iterable<SciencePlan> getSciplan(){
        return sciplanRepository.findAll();
    }
}