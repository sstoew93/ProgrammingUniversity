package app.story.service;

import app.story.model.Story;
import app.story.repository.StoryRepository;
import app.user.model.User;
import app.web.dto.AddStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> findAll() {
        return storyRepository.findAllByVisibleTrue();
    }

    public void newStory(User user, AddStory addStory) {
        Story story = Story.builder()
                .title(addStory.getTitle())
                .description(addStory.getDescription())
                .kind(addStory.getKind())
                .date(addStory.getDate())
                .addedOn(LocalDate.now())
                .author(user)
                .isVisible(false)
                .build();

        this.storyRepository.save(story);
    }

    public void deleteStory(UUID storyId) {
        this.storyRepository.deleteById(storyId);
    }

    public void shareStory(UUID storyId) {
        Story story = storyRepository.findById(storyId)
                .orElseThrow(() -> new RuntimeException("Story not found"));

        story.setVisible(true);

        this.storyRepository.save(story);
    }


    public Optional<Story> findById(UUID storyId) {
        return this.storyRepository.findById(storyId);
    }
}
