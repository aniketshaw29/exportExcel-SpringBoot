package com.aniketshaw29.exportToExcel.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aniketshaw29.exportToExcel.util.Boat;

@Service
public class BoatService {
	
	//addBoat
	//getBoatById
	//DeleteBoatById
	//DeleteAllBoat

	public List<Boat> getSampleBoatList(){
		
		List<Boat> boats = new ArrayList<>();
		
		boats.add(new Boat(101L,"Tornado","Classic", 2014, 454.21));
		boats.add(new Boat(102L,"SuperNova","Classic", 2002, 5654.21));
		boats.add(new Boat(103L,"Calmelio","Santo", 1991, 354.21));
		boats.add(new Boat(104L,"SuperGaint","Hipro", 1857, 254.21));
		boats.add(new Boat(105L,"Titanic","Classic", 1965, 154.21));
		
		return boats;
	}
}
