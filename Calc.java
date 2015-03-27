import java.awt.BorderLayout;

/*Так как в задании не заданы жесткие рамки для создания пользовательского интерфейса – мы будем использовать менеджер размещения BorderLayout, который делит контейнер на пять неравных областей, полностью заполняя каждую область одним компонентом. Области получили географические названия NORTH, SOUTH, WEST, EAST И CENTER. Которые отвечают за верхнюю, нижнюю, левую и правую части графического интерфейса нашего апплета соответственно. При изменении размеров окна,  элементы GUI будут автоматически размещены по указанным сторонам.*/
import java.awt.event.ActionEvent;
//событие, генерируемое при нажатии кнопки
import java.awt.event.ActionListener;
//интерфейс класса, который будет обрабатывать события от кнопки
import javax.swing.*;
//подгружаем библиотеку графических элементов пользовательского интерфейса
public class Calc extends JFrame {
//создаем класс Calc, отвечающий за фрейм
JButton but_calc; //кнопка 1
JButton but_clear; // кнопка 2
JTextArea area_input; // текстовая область
JTextField textfield_out; //текстовое поле
Calc(){
super("Калькулятор расчета символов в тексте");
// название апплета
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//С помощью метода setDefaultCloseOperation мы говорим системе, как отреагировать на закрытие окна. Для того, чтобы при закрытии окна закрывалось и приложение мы передаем параметр JFrame.EXIT_ON_CLOSE
setSize(400, 300); //определяем размер нашего окна (ширина и высота)
setLayout(new BorderLayout());
//метод setLayout( ) - менеджер компоновки
but_calc = new JButton("Рассчитать");
add(but_calc, BorderLayout.EAST);
//создается кнопка с текстом "Рассчитать", размещается в правой части формы
area_input = new JTextArea();
area_input.setLineWrap(true); //распределяет текст по строкам
area_input.setWrapStyleWord(true);
//организация переноса слова на следующую строку целком
add(area_input, BorderLayout.CENTER);
//создается JTextArea - область для ввода текста, размещается в центральной части формы, т.к. это основной элемент интерфейса.
textfield_out = new JTextField(50);
add(textfield_out, BorderLayout.SOUTH);
//создается текстовое поле JTextField размещается в нижней части формы
but_clear = new JButton("Очистить");
add(but_clear, BorderLayout.WEST);
//создается кнопка с текстом "Очистить", размещается в левой части формы
but_calc.addActionListener(new ActionListener()
{
@Override
//Аннотация для проверки переопределения метода.
public void actionPerformed(ActionEvent arg0) {
// При наличии в нашем классе приложения реализации ActionListener и перегрузки метода actionPerformed мы обрабатываем все события кнопки в пределах нашего апплета
if (area_input.getText().trim().length() != 0 )
//проверка текстовой области на наличие в ней введенного текста(любых символов)
{
textfield_out.setText("Количество символов: " + area_input.getText().length() + ", Количество слов: " + area_input.getText().trim().split("\\s+").length);
//производится подсчет символов и количества слов введенных в текстовую область и выводит ее результаты в текстовое поле JTextField
}
else {textfield_out.setText("ОШИБКА: Текст отсутствует!");
// в случае если не введены символы в текстовую область выводится сообщение: " ОШИБКА: Текст отсутствует!"
}
}
});
but_clear.addActionListener(new ActionListener()
{
@Override
//Аннотация для проверки переопределения метода.
public void actionPerformed(ActionEvent arg0) {
// При наличии в нашем классе приложения реализации ActionListener и перегрузки метода actionPerformed мы обрабатываем все события кнопки в пределах нашего апплета
area_input.setText("");
//производится очистка набранных символов.
textfield_out.setText("");
//производится очистка тектового поля-вывода. 
} } ); }
public static void main(String[] args) {

/* public означает, что метод main виден и доступен любому классу. 
void показывает, что метод main не возвращает значение.
main - имя метода main. Все существующие реализации Java-интерпретаторов, получив команду интерпретировать класс, начинают свою работу с вызова метода main. 
Элемент String args[] объявляет параметр с именем args, который является массивом объектов - представителей класса String. Квадратные скобки, стоящие после идентификатора args, говорят о том, что мы имеем дело с массивом, а не с одиночным элементом указанного типа.*/

new Calc().setVisible(true);
//вывод окна на экран.
}
}
