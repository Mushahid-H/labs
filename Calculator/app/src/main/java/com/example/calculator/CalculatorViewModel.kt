package com.example.calculator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel:ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorActions){
        when(action){
            is CalculatorActions.Number -> enterNumber(action.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(action.operation)
            is CalculatorActions.Calculate -> performCalculation()
            is CalculatorActions.Delete -> performDeletion()

        }
    }

    private fun enterOperation(operations: CalculatorOperations){
        if(state.number1.isNotBlank()){
//            state = state.copy(operations=operations)
        }
    }
    private fun enterDecimal(){

    }
    private fun enterNumber(number: Int){

    }
    private fun performCalculation(){

    }
    private  fun performDeletion(){
//        when{
//            state.number2.isNotBlank()->state.copy(
//                number2=state.number2.dropLast(1)
//            )
//            state.operations!=null-> state = state.copy(
//                operations = null
//            )
//            state.number1.isNotBlank()->state=state.copy(
//                number1=state.number1.dropLast(1)
//            )
//        }
    }
}
