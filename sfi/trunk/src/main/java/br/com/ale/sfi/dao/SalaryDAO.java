package br.com.ale.sfi.dao;

import java.util.List;

import br.com.ale.sfi.vo.SalaryVO;

public interface SalaryDAO {

    void insert(List<SalaryVO> salaryList);
}
