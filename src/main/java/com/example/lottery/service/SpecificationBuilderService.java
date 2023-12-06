package com.example.lottery.service;

import com.example.lottery.service.model.SearchCriteria;
import com.example.lottery.utils.Enum;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SpecificationBuilderService<T> {

    public Specification<T> buildSpecification(List<SearchCriteria> searchCriteriaList) {
        if (ObjectUtils.isEmpty(searchCriteriaList)) {
            return null;
        }
        Specification<T> specification = getSpecification(searchCriteriaList.get(0));
        if (searchCriteriaList.size() > 1) {
            searchCriteriaList = searchCriteriaList.subList(1, searchCriteriaList.size());
            for (SearchCriteria item : searchCriteriaList) {
                if (item.getDataOption() == Enum.SearchOption.AND) {
                    specification = Specification.where(specification).and(getSpecification(item));
                } else if (item.getDataOption() == Enum.SearchOption.OR) {
                    specification = Specification.where(specification).or(getSpecification(item));
                }
            }
        }
        return specification;
    }


    public Specification<T> getSpecification(SearchCriteria specificationCriteria) {
        return new Specification<T>() {
            @Serial
            private static final long serialVersionUID = 2089704018494438143L;

            @Override
            public Predicate toPredicate(@NotNull Root<T> root, @NotNull CriteriaQuery<?> query, @NotNull CriteriaBuilder builder) {
                if (specificationCriteria.getValueList() != null) {
                    switch (specificationCriteria.getOperation()) {
                        case IN -> {
                            return root.get(specificationCriteria.getKey()).in(new ArrayList<Object>(specificationCriteria.getValueList()));
                        }
                        case LIKE_LIST_AND -> {
                            List<Predicate> predicates = specificationCriteria.getValueList().stream()
                                .map(item -> builder.like(root.get(specificationCriteria.getKey()), "%-" + item + "-%")).toList();
                            return builder.and(predicates.toArray(new Predicate[]{}));
                        }
                        case LIKE_LIST_OR -> {
                            List<Predicate> predicates = specificationCriteria.getValueList().stream()
                                .map(item -> builder.like(root.get(specificationCriteria.getKey()), "%-" + item + "-%")).toList();
                            return builder.or(predicates.toArray(new Predicate[]{}));
                        }
                        case EQUAL -> {
                            List<Predicate> predicates = specificationCriteria.getValueList().stream()
                                .map(item -> builder.equal(root.get(specificationCriteria.getKey()), item)).toList();
                            return builder.and(predicates.toArray(new Predicate[]{}));
                        }
                    }
                }
                if (specificationCriteria.getValue() != null) {
                    switch (specificationCriteria.getOperation()) {
                        case EQUAL -> {
                            return builder.equal(root.get(specificationCriteria.getKey()), specificationCriteria.getValue());
                        }
                        case GREATER_THAN_EQUAL -> {
                            return builder.greaterThanOrEqualTo(root.get(specificationCriteria.getKey()), (Integer) specificationCriteria.getValue());
                        }
                        case LESS_THAN_EQUAL -> {
                            return builder.lessThanOrEqualTo(root.get(specificationCriteria.getKey()), (Integer) specificationCriteria.getValue());
                        }
                        case GREATER_THAN -> {
                            return builder.greaterThan(root.get(specificationCriteria.getKey()), (Integer) specificationCriteria.getValue());
                        }
                        case LESS_THAN -> {
                            return builder.lessThan(root.get(specificationCriteria.getKey()), (Integer) specificationCriteria.getValue());
                        }
                        // todo more case
                    }
                }
                return null;
            }
        };
    }
}
