package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Deliverable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Date the deliverable is due
    private Calendar dueDate;
    // Values obtained from front-end
    private String inputTime;
    private String inputDate;

    private String title;
    private String description;

    // Project the Deliverable belongs to
    private String projectName;
    private Project project;
    // File to store the submission
    private File file;
    // Default to no file uploaded, update when uploaded
    private String filename = "No file Uploaded";
    // If current date is > than due date deliverable is late
    private boolean late = false;
    private Calendar submissionDate;
    private String status = "No attempt";

    public Deliverable(Calendar dueDate, String title, String description) {
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
    }

    public Deliverable() {}

    public void submit(Calendar currentDate, File file) {
        this.submissionDate = currentDate;
        this.file = file;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public String formatDate() {
        DateFormat formatter = new SimpleDateFormat("EEEE, yyyy - MMMM dd, HH:MM");
        return formatter.format(dueDate.getTime());
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Calendar getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Calendar submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
