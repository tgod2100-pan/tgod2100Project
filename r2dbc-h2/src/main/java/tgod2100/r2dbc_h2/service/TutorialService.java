package tgod2100.r2dbc_h2.service;

import tgod2100.r2dbc_h2.model.Tutorial;
import tgod2100.r2dbc_h2.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tgod2100.r2dbc_h2.model.Tutorial;
import tgod2100.r2dbc_h2.repository.TutorialRepository;

import java.util.Optional;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    public Flux<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    public Flux<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }

    public Mono<Tutorial> findById(long id) {
        return tutorialRepository.findById(id);
    }

    public Mono<Tutorial> save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public  Mono<Tutorial> update(long id, Tutorial tutorial) {
        return tutorialRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> { //flatMap 攤平顯示
                    if (optionalTutorial.isPresent()) {
                        tutorial.setId(id);
                        return  tutorialRepository.save(tutorial);
                    }
                    return  Mono.empty();
        });
    }

    public Mono<Void> deleteById(long id) { return tutorialRepository.deleteById(id); }

    public Mono<Void> deleteAll() { return tutorialRepository.deleteAll(); }

    public Flux<Tutorial> findByPublished(boolean isPublished) {
        return tutorialRepository.findByPublished(isPublished);
    }

}
