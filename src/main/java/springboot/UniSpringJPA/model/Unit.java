package springboot.UniSpringJPA.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "units")
public class Unit {

    @Column(name = "major_type")
    private MajorType majorType;

    @Id
    @Column(name = "unit_code")
    private String unitCode;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "unit_type")
    @Enumerated(EnumType.STRING)        //stringként fogja betenni a DBbe, nem az ordinal()-t
    private UnitType unitType;

    @Column
    private String semesters;

    @Column
    private int credit;

    @Column
    private String preconditions;

    public Unit(String[] line) {
        this(
                line[0],
                line[1],
                line[2],
                UnitType.valueOf(line[3]),
                line[4],
                Integer.parseInt(line[5]),
                line[6]
        );
    }

    public Unit(String majorType,
                String unitCode,
                String unitName,
                UnitType unitType,
                String semesters,
                int credit,
                String preconditions) {
        this.majorType = MajorType.getFacultyTypePerLabel(majorType);
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.unitType = unitType;
        this.semesters = semesters;
        this.credit = credit;
        this.preconditions = preconditions;
    }
}
