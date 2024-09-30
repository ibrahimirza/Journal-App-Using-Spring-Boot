package com.ibrahim.journalApp.journalApp.controller;

import com.ibrahim.journalApp.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryController {

    private Map<Long , JournalEntry> journalEntries=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getId(@PathVariable long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry deleteEntry(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id , @RequestBody JournalEntry myEntry){
        return  journalEntries.put(id , myEntry);
    }

}
