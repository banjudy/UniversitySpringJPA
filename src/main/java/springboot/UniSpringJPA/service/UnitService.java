package springboot.UniSpringJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.UniSpringJPA.Repositories.UnitRepo;
import springboot.UniSpringJPA.model.MajorType;
import springboot.UniSpringJPA.model.Unit;
import springboot.UniSpringJPA.utils.DocumentReader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class UnitService {

    @PersistenceContext
    private EntityManager em;

    private DocumentReader dr;

    private UnitRepo unitRepo;

    @Autowired
    public UnitService(UnitRepo unitRepo, DocumentReader dr) {
        this.unitRepo = unitRepo;
        this.dr = dr;
        saveUnitsToDB();
    }

    public void saveUnitsToDB() {
        dr.allUnits.forEach((majorType, units) -> {
            units.forEach(unit -> {
                unitRepo.save(unit);
            });
        });
    }

    @Transactional
    public List<Unit> listAllUnits(){
        List<Unit> unitList = em.createQuery(
                "SELECT u FROM Unit u", Unit.class)
                .getResultList();
        return unitList;
    }

    @Transactional
    public List<Unit> loadUnitsByMajor(MajorType majorType) {
        List<Unit> units = em.createQuery(
                "SELECT unit FROM Unit unit WHERE unit.majorType = :majorType",
                Unit.class)
                .setParameter("majorType", majorType)
                .getResultList();
        em.find(Unit.class, majorType);
        return units;
    }
}
