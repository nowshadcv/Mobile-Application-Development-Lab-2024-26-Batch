 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnIndexSendButtonClicked(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        EditText editText=(EditText) findViewById(R.id.text);
        String index=editText.getText().toString();
        intent.putExtra("ImageIndex",index);
        startActivity(intent);
    }
    }
