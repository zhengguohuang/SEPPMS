package cn.edu.hyit.seppms.service;


import cn.edu.hyit.seppms.domain.Relation;

import java.util.List;

public interface RelationService extends BaseService<Relation> {
    List<Relation> selectAllByNumber(String number);
    // Relation的共有方法放在这里

}
