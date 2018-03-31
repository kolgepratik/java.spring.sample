package com.kp.first.controller;

import com.kp.first.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;
import java.util.Optional;

public abstract class SCrudRESTController<T extends MongoRepository, V>
    implements ICrudRESTController {
    @Autowired T repository;

    @Override @GetMapping("") public String get() {
        StringBuilder sb = new StringBuilder();

        for (V v : (Collection<V>) this.repository.findAll()) {
            sb.append(v.toString());
        }

        return sb.toString().length() == 0 ? IConstants.STATUS_NOTFOUND : sb.toString();
    }

    @Override @GetMapping("/{id}*") public String getByID(@PathVariable("id") String id) {
        Optional<V> v = this.repository.findById(id);

        return v.isPresent() ? v.get().toString() : IConstants.STATUS_NOTFOUND;
    }

    @Override @PutMapping("/{id}*") public String update(@PathVariable("id") String id) {
        Optional<V> v = this.repository.findById(id);
        if (v.isPresent()) {
            this.repository.save(v.get());
            return IConstants.STATUS_SUCCESS;
        } else {
            return IConstants.STATUS_NOTFOUND;
        }
    }

    @Override @DeleteMapping("/{id}*") public String delete(@PathVariable("id") String id) {
        this.repository.deleteById(id);

        return IConstants.STATUS_SUCCESS;
    }
}
