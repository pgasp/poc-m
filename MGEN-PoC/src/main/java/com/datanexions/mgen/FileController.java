package com.datanexions.mgen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public  String index()
    {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes)
    {
        LocalDateTime start = LocalDateTime.now();
        fileService.uploadFile(file);
        LocalDateTime ended = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(start, ended);

        redirectAttributes.addFlashAttribute("message", "You Successfully Uploaded" + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @PostMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {
        LocalDateTime start = LocalDateTime.now();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileService.uploadFile(file));
        LocalDateTime ended = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(start, ended);

        redirectAttributes.addFlashAttribute("message",
                "You successfully imported all files!" + "\nDuration: " + diff + " milliseconds.");

        return "redirect:/";
    }

    @GetMapping("/{path}/{param1}")
    public ResponseEntity<?> monroeAPI1Param(@PathVariable String path, @PathVariable String param1) throws Exception {
        var contract = fileService.monroeAPI(path, param1, null, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @GetMapping("/{path}/{param1}/{param2}")
    public ResponseEntity<?> monroeAPI2Params(@PathVariable String path, @PathVariable String param1,
                                       @PathVariable String param2) throws Exception {
        var contract = fileService.monroeAPI(path, param1, param2, null);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @GetMapping("/{path}/{param1}/{param2}/{param3}")
    public ResponseEntity<?> monroeAPI3Params(@PathVariable String path, @PathVariable String param1,
                                       @PathVariable String param2, @PathVariable String param3) throws Exception {
        var contract = fileService.monroeAPI(path, param1, param2, param3);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

}
