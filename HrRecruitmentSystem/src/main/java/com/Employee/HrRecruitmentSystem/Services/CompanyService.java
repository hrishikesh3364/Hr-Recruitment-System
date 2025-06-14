package com.Employee.HrRecruitmentSystem.Services;

import com.Employee.HrRecruitmentSystem.DTO.CompanyDto;
import com.Employee.HrRecruitmentSystem.Entity.Company;
import com.Employee.HrRecruitmentSystem.ExceptionHandler.ResourceAlreadyExistsException;
import com.Employee.HrRecruitmentSystem.ExceptionHandler.ResourceNotFoundException;
import com.Employee.HrRecruitmentSystem.Repository.CompanyRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyDto createCompany(CompanyDto dto) {

        if (companyRepository.existsByEmail(dto.getEmail())) {
            throw new ResourceAlreadyExistsException("Company with email " + dto.getEmail() + " is already registered.");
        }

        Company company = modelMapper.map(dto, Company.class);
        Company saved = companyRepository.save(company);
        return modelMapper.map(saved, CompanyDto.class);
    }

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + id));
        return modelMapper.map(company, CompanyDto.class);
    }
}
