package com.challenge.inventoryvaccinated.model.repository.user;

import com.challenge.inventoryvaccinated.model.entity.user.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Integer> {
}
