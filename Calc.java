import java.awt.BorderLayout;

/*Так как в задании не заданы жесткие рамки для создания пользовательского интерфейса – мы будем использовать менеджер размещения BorderLayout, который делит контейнер на пять неравных областей, полностью заполняя каждую область одним компонентом. Области получили географические названия NORTH, SOUTH, WEST, EAST И CENTER. Которые отвечают за верхнюю, нижнюю, левую и правую части графического интерфейса нашего апплета соответственно. При изменении размеров окна,  элементы GUI будут автоматически размещены по указанным сторонам.*/
import javax.swing.*;
//подгружаем библиотеку графических элементов пользовательского интерфейса
public class Calc extends JFrame {
//создаем класс Calc, отвечающий за фрейм
JButton but; //кнопка 1
JButton but2; // кнопка 2
Calc(){
super("Калькулятор расчета символов в тексте");
// название апплета
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//С помощью метода setDefaultCloseOperation мы говорим системе, как отреагировать на закрытие окна. Для того, чтобы при закрытии окна закрывалось и приложение мы передаем параметр JFrame.EXIT_ON_CLOSE
setSize(400, 300); //определяем размер нашего окна (ширина и высота)
setLayout(new BorderLayout());
//метод setLayout( ) - менеджер компоновки
but = new JButton("Рассчитать");
add(but, BorderLayout.EAST);
//создается кнопка с текстом "Рассчитать", размещается в правой части формы

but2 = new JButton("Очистить");
add(but2, BorderLayout.WEST);
//создается кнопка с текстом "Очистить", размещается в левой части формы
}
public static void main(String[] args) {

/* public означает, что метод main виден и доступен любому классу. 
void показывает, что метод main не возвращает значение.
main - имя метода main. Все существующие реализации Java-интерпретаторов, получив команду интерпретировать класс, начинают свою работу с вызова метода main. 
Элемент String args[] объявляет параметр с именем args, который является массивом объектов - представителей класса String. Квадратные скобки, стоящие после идентификатора args, говорят о том, что мы имеем дело с массивом, а не с одиночным элементом указанного типа.*/

new Calc().setVisible(true);
//вывод окна на экран.
}
}
