package com.mungpull.hearing.domain.word.presentation;

import com.mungpull.hearing.domain.user.entity.User;
import com.mungpull.hearing.domain.user.entity.repository.UserRepository;
import com.mungpull.hearing.domain.word.entity.Word;
import com.mungpull.hearing.domain.word.entity.repository.WordRepository;
import com.mungpull.hearing.domain.word.presentation.dto.response.TestHandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/word")
@RequiredArgsConstructor
public class WordController {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<Word> getWordList(@RequestParam Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return wordRepository.findAllByType(user.getAge());
    }

    @GetMapping("/detail")
    public Word getWordDetail(@RequestParam Long wordId) {
        return wordRepository.findById(wordId).orElseThrow(() -> new RuntimeException("Word not found"));
    }

    @GetMapping("/test/hand")
    public TestHandResponse getTestWordList(@RequestParam Long wordId) {
        Word word = wordRepository.findById(wordId).orElseThrow(() -> new RuntimeException("Word not found"));
        List<Word> handList = wordRepository.findAll();
        handList.remove(word);
        return TestHandResponse.builder()
                .answer(word.getMouth())
                .wrong(handList.stream().map(Word::getMouth).toList())
                .build();
    }
    @GetMapping("/test/mouth")
    public TestHandResponse getTestWordListSecond(@RequestParam Long wordId){
        Word word = wordRepository.findById(wordId).orElseThrow(() -> new RuntimeException("Word not found"));
        List<Word> mouthList = wordRepository.findAll();
        mouthList.remove(word);
        return TestHandResponse.builder()
                .answer(word.getHand())
                .wrong(mouthList.stream().map(Word::getHand).toList())
                .build();
    }
}
