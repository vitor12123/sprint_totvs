export default function Header() {
    return (
        <header className="h-18 bg-[#1B1C28] border-b border-[#394150] flex items-center justify-between px-4">

            {/* Logo */}
            <div className="flex items-center gap-2">
                <img
                    src="/logoTotvs.webp"
                    alt="TOTVS"
                    className="w-12 h-12 object-contain"
                />

                <h1 className="text-white text-2xl font-bold">
                    TOTVS
                </h1>
            </div>

            {/* Nexus */}
            <h1 className="text-white text-2xl font-semibold ml-[-4%]">
                Nexus
            </h1>

            {/* Usuário */}
            <div className="flex items-center gap-3 text-gray-300">
                <span className="text-md">♧</span>

                <div className="flex items-center gap-2">
                    <div className="w-10 h-10 rounded-full bg-gray-400 flex items-center justify-center">
                        👤
                    </div>

                    <span className="text-md">
                        User
                    </span>
                </div>
            </div>

        </header>
    );
}