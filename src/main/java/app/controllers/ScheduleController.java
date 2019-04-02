package app.controllers;

import app.models.Project;
import app.models.User;
import app.repositories.ProjectRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ScheduleController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/schedule")
    public String schedule(@ModelAttribute Project select, Model model){

        if(select.getName() == null){

            return "redirect:projects";
        }
        Project project = projectRepository.findByName(select.getName());

        User prof = project.getSupervisor();
        List<String> profSchedule = prof.getAvailability();
        if(profSchedule == null){
            return "redirect:projects";
        }

        ArrayList<User> students = project.getStudents();

        ArrayList<ArrayList<String>> schedules = new ArrayList<>();
        ArrayList<List<String>> profChecks = new ArrayList<>();
        Set<String> availableTimes = new HashSet<>();

        for(User student : students){
            if(student.getAvailability() != null){
                schedules.add(student.getAvailability());
            }
        }
        if(schedules.size() != 0){
            for(ArrayList<String> schedule : schedules ){
                profSchedule.retainAll(schedule);

            }
        }

        if(profSchedule.size() == 0){
            model.addAttribute("found", false);
            model.addAttribute("options", prof.getAvailability());
        }
        else{

            model.addAttribute("options", profSchedule);
            model.addAttribute("found", true);

        }

        model.addAttribute("proj", select);
        model.addAttribute("view", "schedule");
        return "layout";

    }
}
