package com.aniketshaw29.exportToExcel.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniketshaw29.exportToExcel.Service.BoatService;
import com.aniketshaw29.exportToExcel.util.Boat;
import com.aniketshaw29.exportToExcel.util.GenerateExcel;

@RestController
@RequestMapping("/api")
public class BoatController {
	
	@Autowired
	BoatService boatService;

	@GetMapping(value = "/boat/exportToExcel", produces = { "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8" })
	public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
		
		List<Boat> targetList = boatService.getSampleBoatList();

		//generatinf the excel
		GenerateExcel generator = new GenerateExcel(targetList);
        ByteArrayInputStream in = generator.exportToExcel();  

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+"allData-"+ currentDateTime +".xlsx");  
        /*
        application/vnd.ms-excel -> xls
        application/vnd.openxmlformats-officedocument.spreadsheetml.sheet -> xlsx
        text/csv -> csv
        */
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}
	
	
	//addBoat
	//getBoatById
	//DeleteBoatById
	//DeleteAllBoat
	
	
	//later may add pagination
	//similarly a method which bring specific number of records from DB, for specific entries in exporting of excel
}
