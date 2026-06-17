export default function Login() {
    
    function enviar(e) {
        e.preventDefault();

        const email = e.target.email.value;
        const senha = e.target.senha.value;

        console.log("email:", email);
        console.log("senha:", senha);
    }


  return (
    <div className="">

        <div className="bg-white w-96 h-auto rounded-2xl shadow-2xl p-8">
            <h1 className="text-3xl font-bold text-center text-gray-800 mb-2">
            Bem vindo
            </h1>
            <p className="text-center text-gray-500 mb-8">
            Entre na sua conta
            </p>
            <form
            id="form" onSubmit={enviar} >
            <div className="mb-4">
                <label className="text-sm text-gray-600 block">
                Email 
                </label>
                <input
                id="email"
                type="email"
                placeholder="seuEmail@gmail.com"
                className="w-full mt-1 px-4 py-3 border rounded-xl outline-none focus:ring-2 focus:ring-indigo-500"
                />
            </div>
            <div className="mb-6">
                <label className="text-sm text-gray-600 block">
                Senha
                </label>
                <input
                id="senha"
                type="password"
                placeholder="********"
                className="w-full mt-1 px-4 py-3 border rounded-xl outline-none focus:ring-2 focus:ring-indigo-500"
                />
            </div>
            <button 
            id="entrar"
            className="w-full bg-indigo-600 text-white py-3 rounded-xl font-semibold hover:bg-indigo-700 transition">
                Entrar
            </button>
            </form>
        </div>

    </div>
  );
}