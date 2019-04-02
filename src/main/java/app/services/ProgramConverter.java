package app.services;

import app.models.Program;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProgramConverter implements Converter<String, Program> {

    @Override
    public Program convert(String id) {
        int parseId = Integer.parseInt(id);
        List<Program> restrictedPrograms = Arrays.asList(
                new Program(Program.Acronym.AERO.getValue(), Program.Acronym.AERO),
                new Program(Program.Acronym.ARCH.getValue(), Program.Acronym.ARCH),
                new Program(Program.Acronym.CIV.getValue(), Program.Acronym.CIV),
                new Program(Program.Acronym.COMM.getValue(), Program.Acronym.COMM),
                new Program(Program.Acronym.COMP.getValue(), Program.Acronym.COMP),
                new Program(Program.Acronym.MECH.getValue(), Program.Acronym.MECH),
                new Program(Program.Acronym.SOFT.getValue(), Program.Acronym.SOFT),
                new Program(Program.Acronym.SREE.getValue(), Program.Acronym.SREE)

        );
        int index = parseId -1;
        return restrictedPrograms.get(index);
    }
}
