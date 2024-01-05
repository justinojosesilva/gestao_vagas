package br.com.justinojose.gestao_vagas.modules.company.usecases;

import br.com.justinojose.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.justinojose.gestao_vagas.modules.company.entities.JobEntity;
import br.com.justinojose.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.justinojose.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity job) {
        companyRepository.findById(job.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return jobRepository.save(job);
    }
}
