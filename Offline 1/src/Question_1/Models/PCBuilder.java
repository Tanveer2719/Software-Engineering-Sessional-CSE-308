package Question_1.Models;

import Question_1.Product;

import java.util.List;

public interface PCBuilder {

    void  addRAM(List<String> list);
    void  addGraphicsCard(List<String> list);

    Product getPC();
}
