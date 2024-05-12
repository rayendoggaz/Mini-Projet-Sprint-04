package com.rayen.concerts.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.service.ConcertService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ConcertRESTController {

    @Autowired
    private ConcertService concertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Concert> getAllConcerts() {
        return concertService.getAllConcerts();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET) // Use GetMapping instead of RequestMapping with RequestMethod.GET
    public Concert getConcertById(@PathVariable("id") Long id) {
        return concertService.getConcert(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Concert createConcert(@RequestBody Concert concert) {
        return concertService.saveConcert(concert);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Concert updateConcert(@RequestBody Concert concert) {
        return concertService.updateConcert(concert);
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteConcert(@PathVariable("id") Long id) {
        concertService.deleteConcertById(id);
    }
    
    @RequestMapping(value="/genre/{idGenre}",method = RequestMethod.GET)
    public List<Concert> getConcertsByGenreId(@PathVariable("idGenre") Long idGenre) {
        return concertService.findByGenreIdGenre(idGenre);
    }
    
    @RequestMapping(value="/rayen/{idGenre}",method = RequestMethod.GET)
    public List<Concert> getConcertsByGenreId2(@PathVariable("idGenre") Long idGenre) {
        return concertService.findByGenreIdGenre(idGenre);
    }
}
