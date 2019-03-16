package com.spurtti.api.repositories.record;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.spurtti.api.utils.SearchParams;

public abstract class AbstractRecordRepository {
	
	protected static final String FIELD_SPORT_TYPE = "sportType";

	protected Query handleCommonSearchCriteria(Query query, Map<String, Object> searchParams) {
		String sportType = (String) searchParams.get(SearchParams.SPORT_TYPE);
		if (StringUtils.isNotBlank(sportType)) {
			query.addCriteria(Criteria.where(FIELD_SPORT_TYPE).is(sportType));
		}
		return query;
	}
}
