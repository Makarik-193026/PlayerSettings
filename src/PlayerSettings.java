import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerSettings extends JFrame {

    public PlayerSettings() {
        // 1. Главное окно
        setTitle("Настройки плеера");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350); // Размер примерно 450x350
        setLocationRelativeTo(null); // Центрируем окно на экране

        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        // 2. Оформление
        JPanel themePanel = new JPanel(new BorderLayout());
        themePanel.setBorder(BorderFactory.createTitledBorder("Тема оформления"));

        JLabel themeLabel = new JLabel("Тема оформления:");
        themePanel.add(themeLabel, BorderLayout.WEST);

        JPanel themeRadioPanel = new JPanel(new GridLayout(3, 1)); // GridLayout(строки, столбцы) для вертикального расположения
        JRadioButton lightTheme = new JRadioButton("Светлая", true); // true = выбрана по умолчанию
        JRadioButton darkTheme = new JRadioButton("Тёмная");
        JRadioButton systemTheme = new JRadioButton("Системная");

        ButtonGroup themeGroup = new ButtonGroup();
        themeGroup.add(lightTheme);
        themeGroup.add(darkTheme);
        themeGroup.add(systemTheme);

        themeRadioPanel.add(lightTheme);
        themeRadioPanel.add(darkTheme);
        themeRadioPanel.add(systemTheme);

        // Чтобы кнопки не растягивались на всю ширину, обернем их в панель с FlowLayout (выравнивание по левому краю)
        JPanel themeRadioWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        themeRadioWrapper.add(themeRadioPanel);

        themePanel.add(themeRadioWrapper, BorderLayout.CENTER);

        // 3. Уведомления
        JPanel notifyPanel = new JPanel(new BorderLayout());
        notifyPanel.setBorder(BorderFactory.createTitledBorder("Уведомления"));

        JLabel notifyLabel = new JLabel("Уведомления:");
        notifyPanel.add(notifyLabel, BorderLayout.WEST);

        JPanel notifyCheckPanel = new JPanel(new GridLayout(3, 1));
        JCheckBox soundCheck = new JCheckBox("Звук", true); // true = отмечен
        JCheckBox pushCheck = new JCheckBox("Push-уведомления");
        JCheckBox autoSaveCheck = new JCheckBox("Автосохранение");

        notifyCheckPanel.add(soundCheck);
        notifyCheckPanel.add(pushCheck);
        notifyCheckPanel.add(autoSaveCheck);

        // Обертка для выравнивания по левому краю
        JPanel notifyCheckWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        notifyCheckWrapper.add(notifyCheckPanel);

        notifyPanel.add(notifyCheckWrapper, BorderLayout.CENTER);

        // 4. Громкость
        JPanel volumePanel = new JPanel(new BorderLayout(10, 0)); // Отступ 10px между элементами
        volumePanel.setBorder(BorderFactory.createTitledBorder("Громкость"));

        JLabel volumeLabel = new JLabel("Громкость:");
        volumePanel.add(volumeLabel, BorderLayout.WEST);

        JSlider volumeSlider = new JSlider(0, 100, 70); // от 0 до 100, текущее 70
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setPaintTicks(false); // Убираем деления для чистоты, как на макете
        volumePanel.add(volumeSlider, BorderLayout.CENTER);

        JLabel volumeValueLabel = new JLabel("70");

        volumeValueLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        volumePanel.add(volumeValueLabel, BorderLayout.EAST);

        volumeSlider.addChangeListener(e -> volumeValueLabel.setText(String.valueOf(volumeSlider.getValue())));

        // 5. Панели
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 0, 15)); // 3 строки, 1 столбец, отступ 15
        centerPanel.add(themePanel);
        centerPanel.add(notifyPanel);
        centerPanel.add(volumePanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // 6. Кнопки
        JPanel buttonPanel = new JPanel(new BorderLayout());

        JButton resetButton = new JButton("Сбросить");
        JButton applyButton = new JButton("Применить");

        buttonPanel.add(resetButton, BorderLayout.WEST);
        buttonPanel.add(applyButton, BorderLayout.EAST);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            new PlayerSettings().setVisible(true);
        });
    }
}
