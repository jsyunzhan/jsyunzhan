package domain.listen.dao;

import domain.listen.entity.NoteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao {
    

    Integer noteListCount(NoteEntity noteEntity);

    List<NoteEntity> noteList(NoteEntity noteEntity);
}
