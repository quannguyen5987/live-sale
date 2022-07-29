package com.sales.service.stupid;

import com.sales.model.Level;
import com.sales.model.Stupid;
import com.sales.repository.StupidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

@Service
public class StupidServiceImpl implements IStupidService {

    @Autowired
    private StupidRepository stupidRepository;

    @Override
    public Iterable<Stupid> findAll() {
        return stupidRepository.findAll();
    }

    @Override
    public Optional<Stupid> findById(Long id) {
        return stupidRepository.findById(id);
    }

    @Override
    public void save(Stupid level) {
        stupidRepository.save(level);
    }

    @Override
    public void remove(Long id) {
        stupidRepository.deleteById(id);
    }

    @Override
    public Stupid register(HttpServletResponse httpServletResponse) {
        Stupid stupid = new Stupid();
        UUID uuid = UUID.randomUUID();
        stupid.setUuid(String.valueOf(uuid));
        Cookie newCookie = new Cookie("testCookie", stupid.getUuid());
        newCookie.setMaxAge(60);
        httpServletResponse.addCookie(newCookie);
        Level level = new Level();
        level.setId(2L);
        stupid.setLevel(level);
        save(stupid);
        return stupid;
    }
}
