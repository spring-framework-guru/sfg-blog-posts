package guru.springframework.maplombok.svb.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AchTransferPayload {
    private AchTransferObject data;
}
