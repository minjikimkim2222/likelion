let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true },
    { id: 3, title: "Todo 3", done: false}
];

/* >>>>>>>>>>>>>>>> 1 + 2번 구현 <<<<<<<<<<<<<<<<<< */
// 할 일 목록을 화면에 표시하는 함수
function renderTodoList() {
    const todoListContainer = document.getElementById('todo-list');

    // 기존 목록 초기화
    todoListContainer.innerHTML = '';

    // 각 할 일 항목을 순회하며 목록에 추가
    basicDatas.forEach((todo) => {
        const li = document.createElement('li');
        const text = document.createTextNode(todo.title); // 할 일 제목을 텍스트 노드로 만들기
        li.appendChild(text); // <li> 요소에 텍스트 노드 추가
        //console.log(text); 

        if (todo.done) { // Element.classList.add 자바스크립트로 클래스 추가하기
            li.classList.add('done'); // 완료된 항목은 'done' 클래스 추가
        } else {
            li.classList.add('undone'); // 완료되지 않은 항목은 'undone' 클래스 추가
        }

        // 4번 연관 - 클릭이벤트 추가
        li.addEventListener('click', () => {
            updateTodoDoneToggle(todo.id); // 클릭 시 할일 상태 토글시키는 함수
        }); 

        // 5번 연관 - 삭제버튼 + 삭제 이벤트 리스너 추가
        const deleteBtn = document.createElement('button');
        const deleteBtnContent = document.createTextNode('X');
            //console.log(deleteBtnContent);
        deleteBtn.appendChild(deleteBtnContent);
        li.appendChild(deleteBtn);
        deleteBtn.classList.add('delete-button');

            // 삭제 이벤트 리스너 추가
        deleteBtn.addEventListener('click', () => {
            removeTodo(todo.id); // todo 삭제
            renderTodoList();  // 삭제된 투두 화면 다시 렌더링!
        });


        // 최종적으로 li를 todoListContainer 사이에 넣기
        todoListContainer.appendChild(li);

    });
}

document.addEventListener('DOMContentLoaded', () => {
    renderTodoList(); // 돔트리 분석이 끝나면 발생하는 이벤트 설정 - 초기 이벤트
});

/* >>>>>>>>>>>>>>>>> 3번 구현 <<<<<<<<<<<<<<<<<<< */
// 할 일 추가 함수 - addTodo

document.getElementById("todo-input").addEventListener('keydown', (event) => {
    if (event.key == 'Enter') {
        //alert('키보드가 눌렸다!');
        addTodo();
    }
})

function addTodo() {
    //alert('addTodo 함수가 실행되었다!');
    const inputTag = document.getElementById('todo-input');
    const inputValue = inputTag.value;
    console.log(inputValue);

    if (inputValue != ''){
        const newTodo = {
            id: basicDatas.length + 1,
            title: inputValue,
            done: false // 일단 추가했으니 초기값은 false
        };

        basicDatas.push(newTodo);
        renderTodoList();
        inputTag.value = ''; // 입력필드 비우기
    }
}

/* >>>>>>>>>>>>>>> 4번 구현 <<<<<<<<<<<<<<< ; update 기능 (토글; 클릭될 때 상태가 변하는 기능)*/

// 각 할 일 항목에 이벤트 추가
// -> renderTodoList함수 안에 구현

function updateTodoDoneToggle(todoId) {
    //alert('update 함수가 수행됐다!');
    const todo = basicDatas.find(todoEx => todoEx.id == todoId); 
        // 조건에 해당하는 항목 찾으면 해당 항목 반환, 찾지 못하면 'undefined' 반환

    if (todo){
        todo.done = !todo.done; // done 상태 토글
        renderTodoList(); // 변경된 투두 done 상태 다시 렌더링
    }
}

/* >>>>>>>>>>>>>>> 5번 구현 <<<<<<<<<<<<<<< ; delete 기능 */
    // -> renderTodoList() 함수 내부에 삭제 버튼을 li 요소에 추가하고,
    // -> 삭제 버튼 클릭 시 발생하는 이벤트 핸들링 구현 - 해당 항목 제거 + 화면 다시 렌더링

function removeTodo(todoId){
    //alert('delete 함수가 수행됐다!');
    const index = basicDatas.findIndex(todo => todo.id == todoId);
        // 찾으면 해당 인덱스 반환, 없으면 -1 반환

    if (index != -1){ // splice() - 배열의 특정 인덱스에서 제거
        basicDatas.splice(index, 1); // index 위치의 배열 요소 1개를 지우겠다는 의미
        
    }
}