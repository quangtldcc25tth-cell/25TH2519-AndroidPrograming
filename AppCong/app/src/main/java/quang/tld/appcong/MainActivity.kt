package quang.tld.appcong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import quang.tld.appcong.ui.theme.AppCongTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCongTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()), // Thêm cuộn nếu màn hình nhỏ
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Máy tính Đa năng",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Nhãn và ô nhập cho số thứ nhất
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Số thứ nhất") },
            placeholder = { Text("Nhập giá trị số") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nhãn và ô nhập cho số thứ hai
        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Số thứ hai") },
            placeholder = { Text("Nhập giá trị số") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Hàng chứa các nút phép tính
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OperationButton("+", Modifier.weight(1f)) {
                val n1 = number1.toDoubleOrNull() ?: 0.0
                val n2 = number2.toDoubleOrNull() ?: 0.0
                result = (n1 + n2).toString()
            }
            OperationButton("-", Modifier.weight(1f)) {
                val n1 = number1.toDoubleOrNull() ?: 0.0
                val n2 = number2.toDoubleOrNull() ?: 0.0
                result = (n1 - n2).toString()
            }
            OperationButton("×", Modifier.weight(1f)) {
                val n1 = number1.toDoubleOrNull() ?: 0.0
                val n2 = number2.toDoubleOrNull() ?: 0.0
                result = (n1 * n2).toString()
            }
            OperationButton("÷", Modifier.weight(1f)) {
                val n1 = number1.toDoubleOrNull() ?: 0.0
                val n2 = number2.toDoubleOrNull() ?: 0.0
                result = if (n2 != 0.0) (n1 / n2).toString() else "Lỗi (chia cho 0)"
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nút Xóa
        OutlinedButton(
            onClick = {
                number1 = ""
                number2 = ""
                result = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Xóa tất cả")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Hiển thị kết quả
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Kết quả",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (result.isEmpty()) "—" else result,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun OperationButton(symbol: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text = symbol, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    AppCongTheme {
        CalculatorScreen()
    }
}
