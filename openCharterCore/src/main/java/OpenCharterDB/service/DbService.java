package OpenCharterDB.service;

import OpenCharterDB.model.Nave;
import OpenCharterDB.model.Info;
import OpenCharterDB.repository.InfoRepository;
import OpenCharterDB.repository.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbService {
    @Autowired
    private NaveRepository naveRepository;
    private InfoRepository infoRepository;

    public Nave save(Nave nave) {
        return naveRepository.save(nave);
    }

    public Info save(Info info){
        return infoRepository.save(info);
    }

}