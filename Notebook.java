import java.util.*;

public class Notebook {

  int ram;
  int ssd;
  String os;
  String color;

  /**
   * Справочник оперативки
   * 
   * @param ram
   * @return Map
   */
  static Map<Integer, Integer> fillRam(Map<Integer, Integer> ram) {
    ram.put(1, 8);
    ram.put(2, 16);
    ram.put(3, 32);
    ram.put(4, 64);
    return ram;
  }

  /**
   * Справочник SSD
   * 
   * @param ssd
   * @return
   */
  static Map<Integer, Integer> fillSsd(Map<Integer, Integer> ssd) {
    ssd.put(1, 256);
    ssd.put(2, 512);
    ssd.put(3, 1024);
    return ssd;
  }

  /**
   * Справочник ОС
   * 
   * @param os
   * @return
   */
  static Map<Integer, String> fillOs(Map<Integer, String> os) {
    os.put(1, "FreeDOS");
    os.put(2, "Windows");
    os.put(3, "MacOS");
    return os;
  }

  /**
   * Справочник цветов
   * 
   * @param color
   * @return
   */
  static Map<Integer, String> fillColor(Map<Integer, String> color) {
    color.put(1, "Белый");
    color.put(2, "Чёрный");
    color.put(3, "Металлик");
    return color;
  }

  /**
   * Генерация случайных ноутбуков
   * 
   * @param ram
   * @param ssd
   * @param os
   * @param color
   * @return Notebook
   */
  static Notebook generateNotebook(Map<Integer, Integer> ram, Map<Integer, Integer> ssd, Map<Integer, String> os,
      Map<Integer, String> color) {
    Notebook q = new Notebook();
    Random random = new Random();
    int index = random.nextInt(1, 5);
    q.ram = ram.get(index);
    index = random.nextInt(1, 4);
    q.ssd = ssd.get(index);
    index = random.nextInt(1, 4);
    q.os = os.get(index);
    index = random.nextInt(1, 4);
    q.color = color.get(index);
    return q;
  }

  @Override
  public String toString() {
    return ("Оперативка: " + ram + "Гб, " + "SSD: " + ssd + "Гб, " + "Операционка: " + os + ", Цвет: "
        + color);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Notebook)) {
      return false;
    }
    Notebook notebook = (Notebook) obj;
    return ram == notebook.ram && ssd == notebook.ssd && os.equals(notebook.os) && color.equals(notebook.color);
  }

  @Override
  public int hashCode() {
    return 3 * ram + 7 * ssd + 11 * os.hashCode() + 13 * color.hashCode();
  }
}