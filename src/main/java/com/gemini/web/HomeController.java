package com.gemini.web;

import com.gemini.model.*;
import com.gemini.ocs.model.DataProcRequirement;
import com.gemini.repository.EmployeeRepository;
import com.gemini.repository.ObservableSciplanRepository;
import com.gemini.repository.SciplanRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import jparsec.ephem.Target;
import jparsec.observer.LocationElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import org.json.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SciplanRepository sciplanRepository;
    @Autowired
    private ObservableSciplanRepository observableSciplanRepository;

    @GetMapping("/")
    public @ResponseBody String root() {
        return "Welcome welcome";
    }

    @PostMapping(path = "/api/login",consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
//        test user
        Employee user = new Employee("naipawat","password","Naipawat","Poolsawat");
        employeeRepository.save(user);
        if(employeeRepository.findByUsername(username) != null)
        {
            Employee employee = employeeRepository.findByUsername(username);
                if (employee.getUsername().equals(username) && employee.getPassword().equals(password))
                {
                    JSONObject jsonString =  new JSONObject();
                    jsonString.put("token",Jwts.builder().setSubject(employee.getUsername()).claim("roles", "user").setIssuedAt(new Date())
                            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
                    return new ResponseEntity<>(jsonString.toString(),HttpStatus.OK);
                }
        }
        return new ResponseEntity<>("User not found",HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path="/api/testtoken",consumes = "application/json", produces = "application/json")
    public String tokentest(@RequestHeader(name = "token") String headerPersist){
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
            System.out.println(username);
        }catch (Exception e){
            return "Invalid header was passed";
        }
        return "Valid!";
    }

    @PostMapping(path="/api/addsciplan",consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addSciplan(@RequestHeader(name = "token") String headerPersist
                                            ,@RequestBody AddSciplanForm addSciplanForm) throws ParseException {
        String startDate = addSciplanForm.getStartDate();
        String endDate = addSciplanForm.getEndDate();
        Double fundingInUSD = addSciplanForm.getFundingInUSD();
        String objectives = addSciplanForm.getObjectives();
        String starSystem = addSciplanForm.getStarSystem();
        String TELESCOPELOC = addSciplanForm.getTELESCOPELOC();
        dataProc dataProcRequirements = addSciplanForm.getDataProcRequirements();
        ObservingProgram observingProgram = addSciplanForm.getObservingProgram();
        String status = addSciplanForm.getStatus();
                //        Token checking
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
            String creator = username;
            //        Date formatting
        Date StartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date EndDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        sciplanRepository.save(new SciencePlan(creator,fundingInUSD,objectives,starSystem,StartDate,EndDate,TELESCOPELOC,dataProcRequirements,observingProgram,status));
        return new ResponseEntity<>("SciPlan Added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Invalid header was passed, wrong token",HttpStatus.BAD_REQUEST);
        }
    }
//(String creator
//            , String submitter, double fundingInUSD
//            , String objectives, String starSystem
//            , String startDate, String endDate
//            , String telescopeLocation, ArrayList<String> dataProcRequirements
//            , ArrayList<String> observingProgram, String status)
    @GetMapping("/api/getsciplan")
    public @ResponseBody
    ArrayList<SciencePlan> getSciplan(
//            @RequestHeader(name = "token") String headerPersist
    ) throws ParseException {
        filter filter = new filter("testsetse","mamamama","222A",2000,200,200);
        ArrayList<filter> filters = new ArrayList<>();
        filters.add(filter);
        ArrayList<Double> exposures = new ArrayList<>();
        exposures.add((double) 2);
        exposures.add((double) 3);
        locationElement loc = new locationElement();
        loc.setLatitude(Double.parseDouble("133"));
        loc.setRadius(Double.parseDouble("10"));
        loc.setLongitude(Double.parseDouble("60"));
        System.out.println(loc.getLatitude());

        specialEquipment sp = new specialEquipment("eqNametest","ownerNametest","installedDatetest");
        ArrayList<specialEquipment> sps = new ArrayList<>();
        sps.add(sp);

        SciencePlan SciplanValidated = new SciencePlan("naipawat"
                ,new Double(200),"objectives101"
                ,"SUN",new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-10")
                , new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-20")
                ,"HAWAII",new dataProc("PNG",100,"COLOR",-10,60,90)
                ,new ObservingProgram(loc,sps
                                        ,filters,exposures
                                        ,new lens("maketest","modeltest","manutest",1998)
                                        ,true)
                ,"COMPLETE");
        SciplanValidated.setValidated(true);
        sciplanRepository.save(SciplanValidated);
//        try{
//            String username = Jwts.parser()
//                .setSigningKey("secretkey")
//                .parseClaimsJws(headerPersist.replace("Bearer",""))
//                .getBody()
//                .getSubject();
//        }catch (Exception e){
//            return new ArrayList<>();
//        }

        return sciplanRepository.findByValidated(true);
    }

    @GetMapping("/api/getnonvalidatedsciplan")
    public @ResponseBody
    ArrayList<SciencePlan> getNonValidatedSciplan(@RequestHeader(name = "token") String headerPersist) throws ParseException {
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
        }catch (Exception e){
            return new ArrayList<>();
        }
        return sciplanRepository.findByValidated(false);
    }

    @PostMapping("/api/validate")
    public ResponseEntity<String> validateSciplan(@RequestBody PlanNo planNo,@RequestHeader(name = "token") String headerPersist) throws ParseException {
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
        }catch (Exception e){
            return new ResponseEntity<>("Bad token", HttpStatus.BAD_REQUEST);
        }
        SciencePlan sciencePlan = sciplanRepository.findByPlanNo(planNo.getPlanNo());
//        Check starSystem Enum from Target jparsec.ephem
        String[] AvailableNames = Target.getNames();
        List<String> availableNames = Arrays.asList(AvailableNames);
        availableNames.replaceAll(String::toLowerCase);
        String starSystem = sciencePlan.getStarSystem();
        if(!availableNames.contains(starSystem)){
            return new ResponseEntity<>(starSystem+"is an invalid starSystem",HttpStatus.OK);
        }
        //TODO:TELESCOPELOC Enum checking
        //TODO:DataProcRequirements fileType and COLOR_TYPE Enum checking
        //TODO:observingProgram : Try create observingProgram objects by the input received
        //TODO:STATUS Enum checking

        return new ResponseEntity<>("Valid!",HttpStatus.OK);
    }

    @DeleteMapping("/api/delete")
    public ResponseEntity<String> removeSciPlanById(@RequestBody PlanNo planNo,@RequestHeader(name = "token") String headerPersist) {
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
        }catch (Exception e){
            return new ResponseEntity<>("Bad token", HttpStatus.BAD_REQUEST);
        }
        SciencePlan sciplan = sciplanRepository.findByPlanNo(planNo.getPlanNo());
        sciplanRepository.delete(sciplan);
        return new ResponseEntity<>("Sciplan: "+planNo+"is deleted",HttpStatus.OK);
    }

    @PostMapping("/api/submit")
    public ResponseEntity<String> submitSciplan(@RequestBody PlanNo planNo,@RequestHeader(name = "token") String headerPersist){
        try{
            String username = Jwts.parser()
                .setSigningKey("secretkey")
                .parseClaimsJws(headerPersist.replace("Bearer",""))
                .getBody()
                .getSubject();
        }catch (Exception e){
            return new ResponseEntity<>("Bad token", HttpStatus.BAD_REQUEST);
        }
        int planno = planNo.getPlanNo();
        SciencePlan sciplan = sciplanRepository.findByPlanNo(planno);
        observableSciplanRepository.save(sciplan);
        sciplanRepository.delete(sciplan);
        return new ResponseEntity<>("Sciplan: "+planno+"is submitted",HttpStatus.OK);
    }
}