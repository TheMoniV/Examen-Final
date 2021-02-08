package org.sid.graphics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.aspect.logging.MyLog;
import org.sid.aspect.security.SecuredByAspect;
import org.sid.graphics.algorithms.IProcess;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Service
public class Scene {
    private List<Graphic> list = new ArrayList<>();
    private IProcess process;
    @MyLog
    public void addGraphic(Graphic graphic) {
        list.add(graphic);
    }

    public void removeGraphic(Graphic graphic) {
        list.remove(graphic);
    }

    public void traiter(){
        process.process();
    }

    public void serialize() {
        try {
            File file=new File("result.obj");
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            for(Graphic graphic : list) {
                objectOutputStream.writeObject(graphic);
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    @MyLog
    @SecuredByAspect(roles = "USER")
    public void showScene() {
        for(Graphic graphic : list) {
            graphic.draw();
        }
    }
}
