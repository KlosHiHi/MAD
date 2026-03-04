package com.example.lab14

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab14.ui.theme.Lab14Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Создание блока текста с приветсвием
 * @param name Имя для приветсвия
 * @param modifier Свойства для стилизации текстового поля
 * @author Гидрид Калия
 * @since 0.1
 * @sample com.example.lab14.Sample.GreetingSample
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Отображение приветствия на главной странице приложения
 * @author Гидрид Калия
 * @since 0.1
 * @sample com.example.lab14.Sample.GreetingPreviewSample
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab14Theme {
        Greeting("Android")
    }
}

/**
 * Деление двух целых чисел, с проверкой на ноль
 * @param dividend Делимое
 * @param divider Делитель
 * @return Результат деления, число с плавающей точкой
 * @exception ArithmeticException Вызывается при попытке деления на ноль
 * @author Гидрид Калия
 * @since 0.1
 * @sample com.example.lab14.Sample.DivisionSample
 */
fun division(dividend:Int, divider: Int) : Double{
    if(divider == 0)
        throw ArithmeticException("Делить на ноль нельзя")
    return dividend / divider.toDouble()
}

/**
 * Класс для хранения данных входа пользователя
 * @property login Логин пользователя
 * @property password Пароль пользователя
 * @constructor Создание объекта с логином и паролем
 * @author Гидрид Калия
 * @since 0.1
 * @sample com.example.lab14.Sample.UserLoginSample
 */
data class UserLogin(val login: String, val password: String){
    /**
     * Проверка пароля пользователя
     * @param password Проверяемый пароль
     * @return Результат сравнения, совпали пароли или нет
     */
    fun checkPassword(password: String): Boolean{
        return this.password == password
    }
}