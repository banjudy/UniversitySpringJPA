package springboot.UniSpringJPA.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springboot.UniSpringJPA.model.MajorType;
import springboot.UniSpringJPA.model.Unit;
import springboot.UniSpringJPA.model.UnitType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
public class DocumentReader {

    private final String SOURCE_FILE = "src/main/resources/szakok.txt";
    public Map<MajorType, List<Unit>> allUnits = new HashMap<>();

    @Autowired
    public DocumentReader() throws IOException {
        readFile();
        printUnitInfo();
    }


    public void printUnitInfo(){
        for (List<Unit> unitList : allUnits.values()) {
            for (Unit currentUnit : unitList) {
                System.out.println(currentUnit.getMajorType() + ", "
                + currentUnit.getUnitCode() + ", " +
                        currentUnit.getUnitName()+ ", " +
                        currentUnit.getUnitType() + ", " +
                        currentUnit.getSemesters() + ", " +
                        currentUnit.getCredit() + ", " +
                        currentUnit.getPreconditions());
            }
        }
    }

    public void readFile() throws IOException {
        FileReader fileReader = new FileReader(SOURCE_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            String[] parts = line.split(";");
            Unit currentUnit = new Unit(parts);

            allUnits.putIfAbsent(
                    currentUnit.getMajorType(),
                    new ArrayList<>());
            allUnits.get(currentUnit.getMajorType()).add(currentUnit);

        }
    }
}
