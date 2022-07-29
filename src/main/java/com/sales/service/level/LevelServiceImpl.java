package com.sales.service.level;

import com.sales.model.Level;
import com.sales.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LevelServiceImpl implements ILevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Override
    public Iterable<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }

    @Override
    public void save(Level level) {
        levelRepository.save(level);
    }

    @Override
    public void remove(Long id) {
        levelRepository.deleteById(id);
    }
}
