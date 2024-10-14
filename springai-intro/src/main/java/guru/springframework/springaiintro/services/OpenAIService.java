package guru.springframework.springaiintro.services;

import guru.springframework.springaiintro.model.*;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface OpenAIService {

    GetCapitalWithInfoResponse getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
    GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);
    String getAnswer(String question);

    Answer getAnswer(Question question);
}
