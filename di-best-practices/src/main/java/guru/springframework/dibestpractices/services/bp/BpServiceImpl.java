package guru.springframework.dibestpractices.services.bp;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/7/19.
 */
@Service
public class BpServiceImpl implements BpService {
    @Override
    public String getHello() {
        return "The Best Hello!";
    }
}
