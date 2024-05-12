package com.rayen.concerts.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.entities.Genre;
import com.rayen.concerts.service.ConcertService;

import jakarta.validation.Valid;

@Controller
public class ConcertController {

    @Autowired
    ConcertService concertService;
    
    @GetMapping("/accessDenied")
    public String error()
    {
    return "accessDenied";
    }

    @RequestMapping("/listeConcerts")
    public String listeConcerts(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Concert> concerts = concertService.getAllConcertsParPage(page, size);
        modelMap.addAttribute("concerts", concerts);
        modelMap.addAttribute("pages", new int[concerts.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeConcerts";
    }


    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Genre> gen = concertService.getAllGenres();
    	modelMap.addAttribute("concert", new Concert());
    	modelMap.addAttribute("mode", "new");
    	modelMap.addAttribute("genre", gen);
        return "formConcert";
    }

    @RequestMapping("/saveConcert")
    public String saveConcert(@Valid Concert concert, BindingResult bindingResult, 
    		@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
    	int currentPage;
    	boolean isNew = false;
    	if (bindingResult.hasErrors()) return "fromConcert";
    	
    	if (concert.getIdConcert()==null) //ajout
    		isNew=true;
        concertService.saveConcert(concert);
        if (isNew) //ajout
        {
        Page<Concert> prods = concertService.getAllConcertsParPage(page, size);
        currentPage = prods.getTotalPages()-1;
        }
        else //modif
        currentPage=page;
        return ("redirect:/ListeConcerts?page="+currentPage+"&size="+size);
    }


    @RequestMapping("/supprimerConcert")
    public String supprimerConcert(@RequestParam("id") Long id,
                                    ModelMap modelMap,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "2") int size) {
        concertService.deleteConcertById(id);
        Page<Concert> concerts = concertService.getAllConcertsParPage(page, size);
        modelMap.addAttribute("concerts", concerts);
        modelMap.addAttribute("pages", new int[concerts.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeConcerts";
    }


    @RequestMapping("/modifierConcert")
    public String editerConcert(@RequestParam("id") Long id, ModelMap modelMap, 
    		@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Concert concert = concertService.getConcert(id);
        List<Genre> gen = concertService.getAllGenres();
        modelMap.addAttribute("concert", concert);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("genre", gen);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formConcert";
    }

    @RequestMapping("/updateConcert")
    public String updateConcert(@ModelAttribute("concert") Concert concert,
                                @RequestParam("date") String date,
                                ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date concertDate = dateFormat.parse(date);
        concert.setDateConcert(concertDate);

        concertService.updateConcert(concert);
        List<Concert> concerts = concertService.getAllConcerts();
        modelMap.addAttribute("concerts", concerts);
        return "listeConcerts";
    }
}
